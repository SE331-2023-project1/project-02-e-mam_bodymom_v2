package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
