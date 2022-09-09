package se331.lab.rest.dao;

import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .organizer("Kat Laydee")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .organizer("Fern Pollin")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .organizer("Carey Wales")
                .build());
        organizerList.add(Organizer.builder()
                .id(1001L)
                .organizer("Dawg Dahd")
                .build());
        organizerList.add(Organizer.builder()
                .id(1002L)
                .organizer("Kahn Opiner")
                .build());
        organizerList.add(Organizer.builder()
                .id(1003L)
                .organizer("Brody Kill")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id){
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}
