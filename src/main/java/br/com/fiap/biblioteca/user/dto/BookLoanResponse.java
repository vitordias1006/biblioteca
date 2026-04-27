package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.book.model.Book;
import br.com.fiap.biblioteca.user.model.BookLoan;
import br.com.fiap.biblioteca.user.model.User;

public record BookLoanResponse(
        Long id,
        User user,
        Book book)
{
   public static BookLoanResponse fromEntity(BookLoan bookLoan){
       return new BookLoanResponse(
               bookLoan.getId(),
               bookLoan.getUser(),
               bookLoan.getBook()
       );
   }
}
