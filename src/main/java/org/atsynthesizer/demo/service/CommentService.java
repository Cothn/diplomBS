package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Genre;


public interface CommentService {

    public Iterable<Comment> getAllByAudiobookId(Long id);

    public void add( Comment comment);
/*


    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
