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

class DefaultSpeakerRepository : SpeakerRepository {

    override fun fetchSpeakers(): List<Speaker> {
        return listOf(Speaker("Jerry Beers", "tvOS Apprentice, Video Tutorial Instructor"),
            Speaker("Owen Brown", "Tutorial Team Member"),
            Speaker("René Cacheaux", "Tutorial Team Member"),
            Speaker("Wayne Carter", "Couchbase"),
            Speaker("Eric Cerney", "tvOS Apprentice, watchOS 2 by Tutorials"),
            Speaker("Janie Clayton", "Swift Team Lead, Swift Apprentice, NSBrief"),
            Speaker("Tammy Coron", "2D iOS & tvOS Games by Tutorials, tvOS Apprentice, Video Tutorial Instructor"),
            Speaker("Sam Davies", "Android Team Lead, OS X Team Lead, Video Tutorial Instructor"),
            Speaker("James Dempsey", "James Dempsey and the Breakpoints"),
            Speaker("Aaron Douglas", "Core Data by Tutorials, iOS 9 by Tutorials"),
            Speaker("Alexis Gallagher", "Swift Apprentice"),
            Speaker("Matt Galloway", "Swift Apprentice"),
            Speaker("Joshua Greene", "tvOS Apprentice"),
            Speaker("Greg Heo", "Video Tutorial Instructor"),
            Speaker("Erik Kerber", "Swift Apprentice"),
            Speaker("Kelvin Lau", "tvOS Apprentice"),
            Speaker("Matt Luedke", "Tutorial Team Member"),
            Speaker("Jaimee Newberry", "Advisor + Coach, Swingset Inc."),
            Speaker("Vincent Ngo", "iOS 8 and 9 by Tutorials"),
            Speaker("Ryan Nystrom", "watchOS 2 by Tutorials, iOS 8 by Tutorials"),
            Speaker("Jeremy Olson", "Founder of Tapity"),
            Speaker("Mic Pringle", "iOS Team Lead, Video Tutorial Instructor, Podcaster"),
            Speaker("Cesare Rocchi", "iOS 5, 6, and 8 by Tutorials"),
            Speaker("Derek Selander", "iOS 9 by Tutorials"),
            Speaker("Ellen Shapiro", "Tutorial Team Member"),
            Speaker("Audrey Tam", "watchOS 2 by Tutorials, Swift Apprentice"),
            Speaker("Rich Turton", "iOS Animations by Tutorials, iOS 9 by Tutorials, Core Data by Tutorials"),
            Speaker("Ken Yarmosh", "Founder of Savvy Apps"),
            Speaker("Ray Wenderlich", "Editor-in-Chief"),
            Speaker("Vicki Wenderlich", "Artist"),
            Speaker("Jack Wu", "watchOS 2 by Tutorials, iOS 8 by Tutorials")
        ).sortedWith(compareBy({ it.name }))
    }
}