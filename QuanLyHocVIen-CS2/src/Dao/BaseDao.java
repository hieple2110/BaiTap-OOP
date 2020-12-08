package Dao;

import java.io.IOException;


    public interface BaseDao<G> {
        void  viewListStudent() throws IOException;

        void viewStudent() throws IOException;

        void addStudent() throws IOException;

        void updateStudent() throws IOException;

        void deleteStudent() throws IOException;

        void addMarkStudent() throws IOException;

        void sortStudent() throws IOException;
    }

