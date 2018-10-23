package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Videos;

@Repository("videosRepository")
public interface VideosReporitory extends JpaRepository<Videos,Integer>{

}
