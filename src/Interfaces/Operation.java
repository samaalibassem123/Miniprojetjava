package Interfaces;

import models.document.Document;

public interface Operation {
    Boolean EmprunterDocument(Document doc);
    void RetournezDocument(Document doc);
}
