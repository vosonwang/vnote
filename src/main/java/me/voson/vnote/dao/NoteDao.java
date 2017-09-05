package me.voson.vnote.dao;

import me.voson.vnote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteDao extends JpaRepository<Note, String> {
    Note findByShortID(Short shortID);

    @Query(value = "select shortid from note", nativeQuery = true)
    List<Short> findAllShortId();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update note set note=?2,updatetime=current_timestamp  where shortid=?1", nativeQuery = true)
    Integer update(Short shortID,String note);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE from note  where shortid=?1", nativeQuery = true)
    Integer remove(Short shortID);

}
