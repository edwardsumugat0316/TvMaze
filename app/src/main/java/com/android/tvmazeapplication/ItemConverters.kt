package com.android.tvmazeapplication

import androidx.room.TypeConverter
import com.android.tvmazeapplication.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemConverters {
    @TypeConverter
    fun fromString( value: String): List<String>{
        val listType = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(value,listType)
    }
    @TypeConverter
    fun frmList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromExternals(externals: Externals): Int{
        return externals.tvrage
    }

    @TypeConverter
    fun toExternals(tvrage: Int): Externals {
        return Externals(tvrage,tvrage,tvrage)
    }

    @TypeConverter
    fun fromImage(image:Image): String{
        image.original
        return image.medium
    }

    @TypeConverter
    fun toImage(image: String): Image{
        return Image(image,image)
    }

    @TypeConverter
    fun fromPrevious(previous: Previousepisode): String{
        return previous.href
    }

    @TypeConverter
    fun toPrevious(href: String): Previousepisode{
        return Previousepisode(href)
    }

    @TypeConverter
    fun fromSelf(self: Self): String{
        return self.href
    }

    fun toSelf(href: String): Self{
        return Self(href)
    }

    @TypeConverter
    fun fromLinks(links: Links): String{
        links.previousepisode.href
        return links.self.href
    }

    @TypeConverter
    fun toLinks(links: String): Links{
        return Links(toPrevious(links),toSelf(links))
    }

    @TypeConverter
    fun fromCountry(country: Country): String{
        return country.name
    }

    @TypeConverter
    fun toCountry(name: String): Country{
        return Country(name,name,name)
    }

    @TypeConverter
    fun fromNetwork(network: Network?): String?{
        return network?.name
    }

    @TypeConverter
    fun toNetwork(network: String): Network {
        return Network(toCountry(network),network.toInt(),network)
    }

    @TypeConverter
    fun fromRating(rating: Rating): Double{
        return rating.average
    }

    @TypeConverter
    fun toRating(average: Double): Rating{
        return Rating(average)
    }

    @TypeConverter
    fun fromSchedule(schedule: Schedule): String{
        return schedule.time
    }

    @TypeConverter
    fun toSchedule(schedule: String): Schedule{
        return Schedule(listOf(schedule), schedule)
    }

//    @TypeConverter
//    fun fromWebChannel(webChannel: WebChannel): String {
//        return webChannel.name
//    }
//
//    fun toWevChannel(webChannelName: String, webChannelId: Int ): WebChannel{
//        return WebChannel(toCountry(webChannelName),webChannelId,webChannelName)
//    }
}