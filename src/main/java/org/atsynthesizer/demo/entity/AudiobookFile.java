package org.atsynthesizer.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "audiobook_file")
public class AudiobookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "size",  nullable = false)
    private String size;

    @Column(name = "extension",  nullable = false)
    private String extension;

    @Column(name = "file_path",  nullable = false)
    private String filePath;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    @Override
    public String toString() {
        return "AudiobookFile{" +
                "id=" + id +
                ", extension='" + extension + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
