package t1708e.exam.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PublisherCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;
    private String publisherName;
    private String contact;
    private String address;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherCatalog")
    private Set<BookDetail> bookDetails;

    public Set<BookDetail> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(Set<BookDetail> bookDetails) {
        this.bookDetails = bookDetails;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addBook(BookDetail bookDetail) {
        if (this.bookDetails == null) {
            this.bookDetails = new HashSet<>();
        }
        this.bookDetails.add(bookDetail);
    }
}
