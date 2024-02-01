package com.dimchel.fa.core.network

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

internal const val BASE_URL = "https://api.football-data.org/"

internal const val SESSION_HEADER = "X-Auth-Token"
internal const val SESSION_TOKEN = "850f87bfd30f4c50866402773c7ed417"

internal val JSON_CONTENT_TYPE: MediaType = "application/json".toMediaType()