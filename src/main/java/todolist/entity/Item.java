package todolist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "item_id")
    private List<Tag> tags = new ArrayList<>();

    public Item(int id, String name, Groups groups, Priority priority, Status status, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.groups = groups;
        this.priority = priority;
        this.status = status;
        this.tags = tags;
    }

    public Item(int id, String name, Groups groups, Priority priority, Status status) {
        this.id = id;
        this.name = name;
        this.groups = groups;
        this.priority = priority;
        this.status = status;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Groups getGroup() {
        return groups;
    }

    public void setGroup(Groups groups) {
        this.groups = groups;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

}
