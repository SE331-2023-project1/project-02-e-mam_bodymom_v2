package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Announcement;
import se331.project.rest.repository.AnnouncementRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;
    @Override
    public Integer getAnnouncementSize() {
        return Math.toIntExact(announcementRepository.count());
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncements(Integer pageSize, Integer page) {
        return announcementRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Announcement> getAnnouncements(Pageable page) {
        return announcementRepository.findAll(page);
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

}
