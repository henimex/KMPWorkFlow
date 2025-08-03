package com.henimex.tutorial.kmp.workflow.entities

import kotlinx.serialization.Serializable

@Serializable
data class Item(val id: Int, val name: String, val active: Boolean)