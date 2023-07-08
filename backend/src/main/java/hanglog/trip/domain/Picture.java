package hanglog.trip.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Picture {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Lob
    @Basic(fetch = LAZY)
    @Column(nullable = false)
    private byte[] blobImg;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    public Picture(final byte[] blobImg, final Item item) {
        this.blobImg = blobImg;
        this.item = item;
    }
}
