package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Genre;


public interface CommentService {

    public Iterable<Comment> getAllByAudiobook(Audiobook audiobook);

    public void add( Comment comment);

    public void delete( Comment comment);

    public void edit( Comment comment);
/*


    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
