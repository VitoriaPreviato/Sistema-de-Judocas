package org.fpij.jitakyoei.view;

import javax.swing.JPanel;

import net.java.dev.genesis.annotation.Action;
import net.java.dev.genesis.annotation.Form;
import net.java.dev.genesis.ui.swing.SwingBinder;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.view.forms.ProfessorForm;
import org.fpij.jitakyoei.view.gui.ProfessorAtualizarPanel;

@Form
public class ProfessorAtualizarView implements ViewComponent{
	private ProfessorAtualizarPanel gui;
	private ProfessorForm professorForm;
	private AppFacade facade;

	public ProfessorAtualizarView() {
		gui = new ProfessorAtualizarPanel();
		new SwingBinder(gui, this).bind();
		professorForm = new ProfessorForm(gui.getProfessorPanel());
		gui.setVisible(true);
	}
	
	@Action
	public void atualizar() {
		Professor professor = professorForm.pegarBean();
		System.out.println(professor.toString());
	}

	@Override
	public JPanel getGui() {
		return gui;
	}

	@Override
	public void registerFacade(AppFacade fac) {
		this.facade = fac;		
	}
}