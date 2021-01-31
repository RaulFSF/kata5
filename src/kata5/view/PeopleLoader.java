package kata5.view;

import java.util.List;
import kata5.model.Person;

public interface PeopleLoader {
    public abstract List<Person> load();
}
