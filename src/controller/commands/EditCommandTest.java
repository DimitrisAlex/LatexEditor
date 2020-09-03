package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class EditCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);

	@Test
	void test() {
		latexEditorView.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorView.setText("test edit contents\n");
		editCommand.execute();
		String actualContents = latexEditorView.getCurrentDocument().getContents();
		
		assertEquals("test edit contents\n", actualContents);
	}

}
