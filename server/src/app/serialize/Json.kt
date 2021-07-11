package app.serialize

import com.google.gson.JsonDeserializer
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import java.util.*

val serialize: JsonSerializer<Date> = JsonSerializer<Date> { src, _, _ ->
    if (src == null) {
        null
    } else {
        JsonPrimitive(src.time)
    }
}

val deserialize: JsonDeserializer<Date> = JsonDeserializer<Date> { json, _, _ ->
    if (json == null) {
        null
    } else {
        Date(json.asLong)
    }
}

