package com.app.telegraph.utils

import android.app.Activity
import com.app.telegraph.TelegraphApp
val Activity.telegraphApp: TelegraphApp
       get() = application as TelegraphApp