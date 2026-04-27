package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.book.dto.BookSimpleResponse;
import br.com.fiap.biblioteca.book.model.Book;
import br.com.fiap.biblioteca.user.model.BookLoan;
import br.com.fiap.biblioteca.user.model.User;

public record BookLoanResponse(
        Long id,
        UserSimpleResponse user,
        BookSimpleResponse book)
{
   public static BookLoanResponse fromEntity(BookLoan bookLoan){
       return new BookLoanResponse(
               bookLoan.getId(),
               UserSimpleResponse.fromEntity(bookLoan.getUser()),
               BookSimpleResponse.fromEntity(bookLoan.getBook())
       );
   }
}
