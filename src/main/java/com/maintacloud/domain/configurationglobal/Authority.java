package com.maintacloud.domain.configurationglobal;


import com.maintacloud.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "AUTHORITY")
public class Authority extends BaseEntity implements Serializable{

    @Id
    @Column(name = "AUTHORITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long authorityId;

    @Column(name = "NAME", length = 50)
    //@NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority1 = (Authority) o;

        if (authorityId != null ? !authorityId.equals(authority1.authorityId) : authority1.authorityId != null) return false;
        if (name != null ? !name.equals(authority1.name) : authority1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorityId != null ? authorityId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    protected Long getId() {
        return authorityId;
    }

    @Override
    public BaseEntity builEntityToTrack() {
        return null;
    }
}