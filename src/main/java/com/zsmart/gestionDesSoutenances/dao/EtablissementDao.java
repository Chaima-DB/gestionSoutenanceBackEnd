/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.Etablissement;
import java.util.List;

import net.bytebuddy.TypeCache.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface EtablissementDao extends JpaRepository<Etablissement, Long>{
   int deleteByReference(String reference);
   Etablissement findByReference(String reference);
}
