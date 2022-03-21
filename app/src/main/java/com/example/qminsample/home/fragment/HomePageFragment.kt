package com.example.qminsample.home.fragment

import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qminsample.R
import com.example.qminsample.databinding.FragmentHomePageBinding
import com.example.qminsample.dataclass.GenericChannel
import com.example.qminsample.dataclass.GenericData
import com.example.qminsample.dataclass.GenericList
import com.example.qminsample.dataclass.RestaurantDataClass
import com.example.qminsample.home.adapters.CustomChannelAdapter
import com.example.qminsample.home.adapters.GenericChannelAdapter
import com.example.qminsample.home.adapters.RestaurantNearYou
import com.example.qminsample.home.adapters.SpotLightAdapter
import com.google.gson.Gson

class HomePageFragment : Fragment() {
    private var resDataClass = arrayListOf<RestaurantDataClass>()
    private lateinit var idbind: FragmentHomePageBinding
    private var channelBind = arrayListOf<GenericData>()
    private var location: LocationManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        idbind = FragmentHomePageBinding.inflate(inflater, container, false)
        return idbind.root


    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        genericChannel()
        customChannel()
        festivals()
        restaurantNear()
        resHotel()
        locationGet()

    }

    private fun genericChannel() {
        val Gchannel = "{\n" +
                "  \"statusCode\": 200,\n" +
                "  \"message\": \"Successfully fetched the channels\",\n" +
                "  \"result\": {\n" +
                "    \"is_outside_visible\": false,\n" +
                "    \"generic_channels\": [\n" +
                "      {\n" +
                "        \"name\": \"Q-Kids\",\n" +
                "        \"id\": \"cfd381e4-be54-4e6e-af07-528d6fac6c09\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Kids-discovery-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Qmin Kids\",\n" +
                "        \"body_hero_text\": \"Kids Special Menu\",\n" +
                "        \"body_description\": \"An all-things Kids menu curated for those little eyes to light up. Fun-filled meals, tasty bites and delicious treats filled with exciting ingredients with a colourful twist. All-time favourites like jalapeno poppers, nuggets, burgers, chocolate brownies and more that kids will love. Let the fun begin!\",\n" +
                "        \"query_attribute\": \"qmin_kids\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_kids\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Family Feast\",\n" +
                "        \"id\": \"e98b91f8-5978-4969-93e5-33d87a9dc4fa\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/family-feast/Qmin_Platter_Banner_326-90-px.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Family Feast\",\n" +
                "        \"body_hero_text\": \"Family Meals\",\n" +
                "        \"body_description\": \"Family Meals\",\n" +
                "        \"query_attribute\": \"Q_family\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"973c2f0b-e194-4c08-889c-85c8ee8d3241\",\n" +
                "        \"static_content_url\": \"base_url?catgory=Q_family\",\n" +
                "        \"channel_description\":\"Family feast for family time\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Signature\",\n" +
                "        \"id\": \"21caa2b8-0294-4ecf-b8ad-82e6c3dbf357\",\n" +
                "        \"image_url\": \"https://tatadigital-prod.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/dawaat-e-khaas/Banner2.png/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Signatures\",\n" +
                "        \"body_hero_text\": \"Meals for all\",\n" +
                "        \"body_description\": \"One Box Meals and Biryani Platters\",\n" +
                "        \"query_attribute\": \"Q_Signature\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"28a8701d-ca3e-42b3-9ef9-01c8a7728728\",\n" +
                "        \"static_content_url\": \"base_url?catgory=Q_Signature\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Patisserie\",\n" +
                "        \"id\": \"519accaa-25fe-4259-91a9-cb0073dd9a15\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/la-patisserie/Qmin_La-Patisserie_640-PX.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Patisserie\",\n" +
                "        \"body_hero_text\": \"Patisserie\",\n" +
                "        \"body_description\": \"Cake shop and delicatessen, offers delicious desserts, & freshly baked breads and savoury treat\",\n" +
                "        \"query_attribute\": \"la_patisserie\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=la_patisserie\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Comfort\",\n" +
                "        \"id\": \"b42621ad-a75d-4e86-bee1-cb466e2a1d76\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Comfort-discovery-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Qmin Comfort\",\n" +
                "        \"body_hero_text\": \"Happiness Delivered\",\n" +
                "        \"body_description\": \"Soulful Combo Meals, Nostalgic Flavours, Sweet Cravings. All-of-your-favourite comfort food, just a click away as you smile away your every mood. With Qmin, every day let comfort come home.\",\n" +
                "        \"query_attribute\": \"qmin_comfort\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_comfort\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Innergise\",\n" +
                "        \"id\": \"42c864e3-93b6-4d6b-972d-8cea4b3f218b\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/16.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Innergise\",\n" +
                "        \"body_hero_text\": \"Nourish and Relish\",\n" +
                "        \"body_description\": \"A special menu packed with anti-oxidants and immunity-boosting superfoods. Featuring healthy dishes like Ragi Uttapams, Amchoori Kale Chane, Quinoa Methi Tikki to Gond Ke Ladoo and Rabdi aur Sabja, make for wholesome nutritious meals. Reconnect with your roots and Innergise with soulful & authentic flavours delivered at the comfort of your home.\",\n" +
                "        \"query_attribute\": \"la_pat\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=la_pat\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"custom_channels\": [\n" +
                "      {\n" +
                "        \"name\": \"Celebrations\",\n" +
                "        \"id\": \"e0c80c29-532d-4a9f-b597-4a368b4c1778\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Comfort-discover-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"\",\n" +
                "        \"body_hero_text\": \"\",\n" +
                "        \"body_description\": \"\",\n" +
                "        \"query_attribute\": \"qmin_celebrations\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_celebrations\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"custom\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Hampers\",\n" +
                "        \"id\": \"45058e01-8475-461f-8c69-704442e73933\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/family-feast/Qmin_Platter_Banner_640-px.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2021-12-01T15:37:55.7Z\",\n" +
                "        \"header_text\": \"\",\n" +
                "        \"body_hero_text\": \"\",\n" +
                "        \"body_description\": \"\",\n" +
                "        \"query_attribute\": \"qmin_hampers\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"27b89ad5-7368-47d0-8eb8-ce5dd255b9ce\",\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_hampers\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": true,\n" +
                "        \"type\": \"custom\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"is_encrypted\": false\n" +
                "}"
        val gson = Gson().fromJson(Gchannel, GenericChannel::class.java)
        var gData = gson.result.generic_channels
        println(">>------->>>>>>" + gData)
        idbind.rvGenericChannels.adapter =
            GenericChannelAdapter(requireContext(),gData)
    }

    private fun customChannel() {
        var customCeleName = arrayOf("Qmin Celebrations", "Hampers", "Qmin Celebrations")
        var customCeleDesc = arrayOf(
            "One stop shop for all your  \n" +
                    "virtual celebrations",
            "Exclusive bundles of delight",
            "One stop shop for all your  \n" +
                    "virtual celebrations",
            "Exclusive bundles of delight",
            "One stop shop for all your  \n" +
                    "virtual celebrations",
            "Exclusive bundles of delight"
        )
        idbind.rvCustomChannels.adapter =
            CustomChannelAdapter(requireContext(), customCeleName, customCeleDesc)
        idbind.rvCustomChannels.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun festivals() {
        var fesImage = arrayOf(
            R.drawable.tajimage,
            R.drawable.tajimage,
            R.drawable.tajimage,
            R.drawable.tajimage
        )
        var fesName = arrayOf(
            "Christmas", "Valentine’s\n" +
                    "Day", "Valentine’s\n" +
                    "Day", "Valentine’s\n" +
                    "Day"
        )
        idbind.rvSpotLight.adapter = SpotLightAdapter(fesImage, fesName)
        idbind.rvSpotLight.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun restaurantNear() {
        idbind.rvRestaurantsNearYou.adapter = RestaurantNearYou( resDataClass)
        idbind.rvRestaurantsNearYou.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun resHotel() {
        var tajLand = arrayOf(
            "Indian","Golden Dragon","Golden Dragon","Golden Dragon"
        )
        var tajCategory = listOf("Indian", "chinese","Golden Dragon","Golden Dragon")

        var tajMahal = arrayOf("The Taj Mahal Palace", "Taj Lands End","Golden Dragon","Golden Dragon", "hggfgfcg",)
        var tajMahalCategory = listOf("Golden Dragon", "Ming Yang", "bhbjbjh","Golden Dragon","Golden Dragon")

        resDataClass.add(RestaurantDataClass("The TajLands", tajLand, tajCategory))
        resDataClass.add(RestaurantDataClass("The Taj Mahal Palace", tajMahal, tajMahalCategory))

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun locationGet() {
        val locationPermission =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
                when {
                    permission.getOrDefault(
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        false
                    ) -> {

                    }
                    permission.getOrDefault(
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        false
                    ) -> {

                    }
                    else -> {

                    }
                }
            }
        locationPermission.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}