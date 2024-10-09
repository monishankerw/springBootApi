package com.demoParsing.items.respository;

import com.demoParsing.items.entity.Iteam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IteamRepository extends JpaRepository<Iteam, Long> {
}
