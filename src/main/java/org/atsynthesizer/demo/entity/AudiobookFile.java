package org.atsynthesizer.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "audiobook_file")
public class AudiobookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "extension",  nullable = false)
    private String extension;

    @Column(name = "file_path",  nullable = false)
    private String filePath;

    @Override
    public String toString() {
        return "AudiobookFile{" +
                "id=" + id +
                ", title='" + extension + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
