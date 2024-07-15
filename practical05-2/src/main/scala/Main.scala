case class Book(title: String, author: String, isbn: String)

object LibraryManagement {

  var library: Set[Book] = Set(
    Book("Kaalaya", "Perera", "343423"),
    Book("The Time", "Silva", "453454"),
    Book("Harry Potter", "Rowling", "324324")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Book '${book.title}' added to the library.")
  }

  def removeBook(isbn: String): Unit = {
    var itemFound = false

    for (book <- library) {
      if (book.isbn == isbn) {
        library -= book
        itemFound = true
        println(s"Book '${book.title}' removed")
      }
    }
    if (!itemFound) {
      println(s"No book found for ISBN $isbn.")
    }
  }

  def checkBook(isbn: String): Boolean = {
    var found = false
    for (book <- library) {
      if (book.isbn == isbn) {
        found = true
      }
    }
    found
  }

  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("Empty")
    } else {
      library.foreach { book =>
        println(
          s"Title - ${book.title}, Author - ${book.author}, ISBN - ${book.isbn}"
        )
      }
    }
  }

  def searchBookByTitle(): Unit = {
    println("Enter the title to Search")
    val titleToSearch = scala.io.StdIn.readLine()

    var found = false
    for (book <- library) {
      if (book.title.equalsIgnoreCase(titleToSearch)) {
        found = true
        println("Book Found")
        println(
          s"Details: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"
        )
      }
    }

    if (!found) {
      println(s"Book Not Found")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    var itemFound = false

    for (book <- library) {
      if (book.author == author) {
        itemFound = true
        println(
          s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"
        )
      }
    }
    if (!itemFound) {
      println(s"No books found by author $author.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Library Collection - ")
    displayLibrary()

    println("\nAdding Book")
    addBook(Book("Madol Duwa", "ABS", "34234"))

    println("\nRemove Book")
    removeBook("453454")

    println("\nChecking if a book is in the library by ISBN:")
    println(checkBook("343423"))

    println("\nSearching for a book by title:")
    searchBookByTitle()

    println("\nDisplaying all books by a specific author:")
    displayBooksByAuthor("Silva")
  }
}
