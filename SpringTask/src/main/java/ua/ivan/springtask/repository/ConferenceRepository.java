package ua.ivan.springtask.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.ivan.springtask.entity.Conference;
import ua.ivan.springtask.entity.Report;
import ua.ivan.springtask.entity.User;

import java.util.List;

@Repository
public interface ConferenceRepository extends PagingAndSortingRepository<Conference, Long> {
    Conference findConferenceById(Long id);

    List<Conference> findAll();

    List<Conference> findAllByRegisteredGuestsContainsAndApprovedIsTrueAndFinishedIsFalse(User user);

    List<Conference> findAllByRegisteredGuestsContains(User user);

    List<Conference> findAllByReportsContaining(Report report);

    List<Conference> findAllByApprovedIsTrueAndFinishedIsFalse();

    List<Conference> findAllByFinishedIsFalseAndApprovedIsTrue();

    List<Conference> findAllByApprovedIsFalse();

    List<Conference> findAllByFinishedIsTrue();

    List<Conference> findAllByApprovedIsTrueAndFinishedIsFalse(Pageable pageable);

    Long countAllByApprovedIsTrueAndFinishedIsFalse();
}
