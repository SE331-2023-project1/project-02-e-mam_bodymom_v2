package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    Integer getAnnouncementSize();
    Announcement save (Announcement announcement);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);
    List<Announcement> getAnnouncements();
    Announcement getAnnouncement(Long id);
}
