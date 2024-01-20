package com.servlets;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			fetchNoteId
		int noteId=Integer.parseInt(request.getParameter("note_id").trim());
//		create session
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		
		Note note=(Note)s.get(Note.class, noteId);
		s.delete(note);
		tx.commit();
		s.close();
		response.sendRedirect("all_notes.jsp");
		}
		catch(Exception e) {
			
		}
	
	
	}

}
