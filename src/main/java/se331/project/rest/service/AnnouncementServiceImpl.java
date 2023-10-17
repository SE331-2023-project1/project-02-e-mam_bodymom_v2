package se331.project.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AnnouncementDao;
import se331.project.rest.entity.Announcement;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    final AnnouncementDao announcementDao;
    @Override
    public Integer getAnnouncementSize() {
        return announcementDao.getAnnouncementSize();
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementDao.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncements(Integer pageSize, Integer page) {
        return announcementDao.getAnnouncements(pageSize, page);
    }

    @Override
    public List<Announcement> getAnnouncements() {
        return announcementDao.getAnnouncements(Pageable.unpaged()).getContent();
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementDao.getAnnouncement(id);
    }
}
