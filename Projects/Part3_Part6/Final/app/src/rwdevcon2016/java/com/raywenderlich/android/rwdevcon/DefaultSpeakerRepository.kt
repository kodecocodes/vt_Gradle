/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.rwdevcon

import com.raywenderlich.android.rwdevconlib.Speaker
import com.raywenderlich.android.rwdevconlib.SpeakerRepository

class DefaultSpeakerRepository : SpeakerRepository {

    override fun fetchSpeakers(): List<Speaker> {
        return listOf(
            Speaker("Christine Abernathy", "Android for iOS Developers"),
            Speaker("Jawwad Ahmad", "Xcode Tips & Tricks"),
            Speaker("Namrata Bandekar", "App Development Workflow"),
            Speaker("Gemma Barlow", "Auto Layout Best Practices"),
            Speaker("René Cacheaux", "Advanced Unidirectional Architecture"),
            Speaker("Janie Clayton", "Integrating Metal Shaders with SceneKit"),
            Speaker("Tammy Coron", "Keynote Speaker & Room Host"),
            Speaker("Alex Curran", "Spring Cleaning Your App"),
            Speaker(
                "Sam Davies",
                "Cloning Netflix: Surely it Can't be That Hard"
            ),
            Speaker("James Dempsey", "Inspiration Talk"),
            Speaker("Joey Devilla", "ARKit Workshop and Tutorial"),
            Speaker("Ray Fix", "Swift 4 Serialization"),
            Speaker("Dru Freeman", "Embracing the Different"),
            Speaker("Joe Howard", "Clean Architecture on Android"),
            Speaker("Cate Huston", "Inspiration Talk"),
            Speaker("Michael Katz", "Architecting Modules"),
            Speaker("Patrick Kwete", "Machine Learning Workshop"),
            Speaker("Kelvin Lau", "Swift Collection Protocols Workshop"),
            Speaker("Anthony Lockett", "Clean Architecture on iOS"),
            Speaker("Vincent Ngo", "Swift Collection Protocols Workshop"),
            Speaker(
                "Andy Obusek",
                "Improving App Quality with Test Driven Development"
            ),
            Speaker("Luke Parham", "Practical Instruments Workshop"),
            Speaker("Ellen Shapiro", "Living Style Guides"),
            Speaker("Eric Soto", "Advanced WKWebView"),
            Speaker("Phillip Shoemaker", "Lessons from the App Store"),
            Speaker("Daniel Steinberg", "The Game of Life"),
            Speaker("Lea Marolt Sonnenschein", "Custom Views"),
            Speaker("Audrey Tam", "Machine Learning Workshop"),
            Speaker("Rich Turton", "The Art of the Chart")
        ).sortedWith(compareBy({ it.name }))
    }
}