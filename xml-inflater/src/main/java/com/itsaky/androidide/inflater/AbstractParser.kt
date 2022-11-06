/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.androidide.inflater

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import com.itsaky.androidide.inflater.internal.utils.defaultGravity
import com.itsaky.androidide.inflater.internal.utils.unknownDrawable

/**
 * Abstract class which provides access to the internal parsing utility methods to its subclasses.
 *
 * @author Akash Yadav
 */
abstract class AbstractParser {
  
  /**
   * Parses the given string value representing an integer or reference to an integer resource to
   * its actual value.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseFloat(value: String, def: Float = 0f): Float {
    return com.itsaky.androidide.inflater.internal.utils.parseFloat(value = value, def = def)
  }
  
  /**
   * Parses the given string value representing an integer or reference to an integer resource to
   * its actual value.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseInteger(value: String, def: Int = 0): Int {
    return com.itsaky.androidide.inflater.internal.utils.parseInteger(value = value, def = def)
  }

  /**
   * Parses the given string value representing a boolean or reference to an boolean resource to its
   * actual value.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseBoolean(value: String, def: Boolean = false): Boolean {
    return com.itsaky.androidide.inflater.internal.utils.parseBoolean(value = value, def = def)
  }

  /**
   * Parses the given string value representing a color or reference to a drawable resource to an
   * actual drawable which can be rendered.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseDrawable(
    context: Context,
    value: String,
    def: Drawable = unknownDrawable()
  ): Drawable {
    return com.itsaky.androidide.inflater.internal.utils.parseDrawable(
      context = context,
      value = value,
      def = def
    )
  }

  /**
   * Parses the gravity flags which can be single flag value like `center` or a multiple combined
   * flag values like `start|top`.
   *
   * @param value The gravity string.
   * @param def The default gravity flag value.
   */
  @JvmOverloads
  protected open fun parseGravity(value: String, def: Int = defaultGravity()): Int {
    return com.itsaky.androidide.inflater.internal.utils.parseGravity(value = value, def = def)
  }

  /**
   * Parses the given string value representing a dimension value or reference to a dimension
   * resource to its actual value.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseDimension(context: Context, value: String, def: Int = 0): Int {
    return com.itsaky.androidide.inflater.internal.utils
      .parseDimension(context = context, value = value, def = def.toFloat())
      .toInt()
  }

  /**
   * Parses the given string value representing a color code or reference to a color resource to its
   * actual value.
   *
   * @param value The string value. Usually value from attributes.
   * @param def The default value.
   */
  @JvmOverloads
  protected open fun parseColor(
    context: Context,
    value: String,
    def: Int = Color.TRANSPARENT
  ): Int {
    return com.itsaky.androidide.inflater.internal.utils.parseColor(
      context = context,
      value = value,
      def = def
    )
  }
}