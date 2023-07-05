package com.FireBaseCrudOperations.Service;

import com.FireBaseCrudOperations.Config.FireBaseConfig;
import com.FireBaseCrudOperations.Data.FireBaseDto;
import com.FireBaseCrudOperations.Service.Impl.FireBaseImpl;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FireBaseService implements FireBaseImpl {

    @Autowired
    private FireBaseConfig fireBaseConfig;

    // Retrieve a list of Firebase documents
    @Override
    public List<FireBaseDto> list() {
        List<FireBaseDto> response = new ArrayList<>();
        FireBaseDto post;

        // Get the query snapshot for the collection
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            // Iterate over each document in the query snapshot
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                // Convert the document to a FireBaseDto object
                post = doc.toObject(FireBaseDto.class);
                // Set the document ID in the FireBaseDto object
                post.setId(doc.getId());
                // Add the FireBaseDto object to the response list
                response.add(post);
            }
            // Return the list of FireBaseDto objects
            return response;
        } catch (Exception e) {
            // Return null if an exception occurs
            return null;
        }
    }

    // Add a new Firebase document
    @Override
    public String add(FireBaseDto post) {
        // Create a map with the document data
        Map<String, Object> docData = getDocData(post);

        // Create the document with the data in the collection
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            // Check if the write operation was successful
            if (null != writeResultApiFuture.get()) {
                return "Data added successfully.";
            }
            return "Failed to add data.";
        } catch (Exception e) {
            return "Error occurred while adding data.";
        }
    }

     // Retrieve a Firebase document by ID
    @Override
    public FireBaseDto getById(String id) {
        // Get the document snapshot for the specified ID
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = getCollection().document(id).get();
        try {
            // Check if the document exists
            if (documentSnapshotApiFuture.get().exists()) {
                // Convert the document to a FireBaseDto object
                FireBaseDto post = documentSnapshotApiFuture.get().toObject(FireBaseDto.class);
                // Set the document ID in the FireBaseDto object
                post.setId(documentSnapshotApiFuture.get().getId());
                // Return the FireBaseDto object
                return post;
            } else {
                // Return null if the document does not exist
                return null;
            }
        } catch (Exception e) {
            // Return null if an exception occurs
            return null;
        }
    }

    // Edit an existing Firebase document
    @Override
    public String edit(String id, FireBaseDto post) {
        // Create a map with the updated document data
        Map<String, Object> docData = getDocData(post);
        // Update the document with the new data
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);

        try {
            // Check if the write operation was successful
            if (null != writeResultApiFuture.get()) {
                return "Data updated successfully.";
            }
            return "Failed to update data.";
        } catch (Exception e) {
            return "Error occurred while updating data.";
        }
    }

    // Delete a Firebase document
    @Override
    public String delete(String id) {
        // Delete the document with the specified ID
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();

        try {
            // Check if the write operation was successful
            if (null != writeResultApiFuture.get()) {
                return "Data deleted successfully.";
            }
            return "Failed to delete data.";
        } catch (Exception e) {
            return "Error occurred while deleting data.";
        }
    }

    // Helper method to convert FireBaseDto object to a map of document data
    private static Map<String, Object> getDocData(FireBaseDto post) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("Name", post.getName());
        docData.put("Profession", post.getProfession());
        docData.put("Id", post.getId());
        return docData;
    }

    // Helper method to get the Firebase collection reference
    private CollectionReference getCollection() {
        return fireBaseConfig.getFirestore().collection("FireBase-Crud-Operations");
    }
}
