package fr.tikione.jacocoverage.plugin;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SMALL_ICON;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.FileOwnerQuery;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
import org.openide.util.ContextAwareAction;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;

/**
 * The "Test File with JaCoCoverage" contextual action registration.
 * Start the "test-single" Ant task with the JaCoCo JavaAgent correctly configured, colorize Java source file and show a coverage report.
 *
 * @author Jonathan Lermitage
 */
@ActionID(category = "Project",
          id = "fr.tikione.jacocoverage.plugin.TestSingleWithJaCoCoAction")
@ActionRegistration(displayName = "#CTL_TestSingleWithJaCoCoAction",
                    lazy = true)
@ActionReferences({
    @ActionReference(path = "Loaders/text/x-java/Actions",
                     position = 1268),
    @ActionReference(path = "Editors/text/x-java/Popup",
                     position = 1785)
})
@Messages("CTL_TestSingleWithJaCoCoAction=Test File with JaCoCoverage")
public final class TestSingleWithJaCoCoAction extends AbstractAction implements ContextAwareAction {

    @StaticResource
    private static final String ICON = "fr/tikione/jacocoverage/plugin/resources/icon/eclemma_report.gif";

    private static final long serialVersionUID = 1L;

    public @Override
    void actionPerformed(ActionEvent e) {
    }

    public @Override
    Action createContextAwareInstance(Lookup context) {
        return new ContextAction(context);
    }

    /**
     * The "Test File with JaCoCoverage" contextual action.
     */
    private static final class ContextAction extends JaCoCoContextAction {

        private static final long serialVersionUID = 1L;

        /**
         * Enable the context action on supported projects only.
         *
         * @param context the context the action is called from.
         */
        public ContextAction(Lookup context) {
            super(context, FileOwnerQuery.getOwner(context.lookup(DataObject.class).getPrimaryFile()), "test-single");
            putValue(NAME, Bundle.CTL_TestSingleWithJaCoCoAction());
            putValue(SMALL_ICON, ImageUtilities.loadImageIcon(ICON, false));
        }

        public @Override
        void actionPerformed(ActionEvent ae) {
            // TODO add needed properties.
//            getAddAntTargetProps().put("classname", "demo.coverage.app.Utility1Test");
//            getAddAntTargetProps().put("javac.includes", "demo.coverage.app.Utility1Test");
//            getAddAntTargetProps().put("test.includes", "demo.coverage.app.Utility1Test");
            super.actionPerformed(ae);
        }
    }
}
