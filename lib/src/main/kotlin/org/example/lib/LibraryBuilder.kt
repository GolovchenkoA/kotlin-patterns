package org.example.lib

import java.time.LocalDateTime

class LibraryJavaBuilder {
    private lateinit var books: List<String>
    private lateinit var opensAt: LocalDateTime
    private lateinit var closesAt: LocalDateTime

    fun setBooks(books: List<String>): LibraryJavaBuilder {
        this.books = books
        return this
    }

    fun setOpensAt(opensAt: LocalDateTime): LibraryJavaBuilder {
        this.opensAt = opensAt
        return this
    }

    fun setClosesAt(closesAt: LocalDateTime): LibraryJavaBuilder {
        this.closesAt = closesAt
        return this
    }

    fun createLibrary(): Library {
        return Library(books, opensAt, closesAt)
    }
}