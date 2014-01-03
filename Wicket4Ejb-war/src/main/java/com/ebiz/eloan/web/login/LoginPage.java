package com.ebiz.eloan.web.login;

import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.wicketstuff.javaee.example.dao.ContactDaoLocal;
import org.wicketstuff.javaee.example.model.Contact;

public class LoginPage extends WebPage {

    private static final long serialVersionUID = 1L;
    @EJB(name = "ContactDaoBean")
    private ContactDaoLocal contactDao;
    private Form<Object> form;

    public LoginPage(final PageParameters parameters) {
//		super(parameters);
//
//		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's components here
//        super(parameters);
        form = new Form<Object>("form");
        this.add(form);

        // テキスト
        form.add(new TextField<String>("UID"));
        // パスワード
        form.add(new PasswordTextField("PWD"));

        // ログインボタン
        Button button = new Button("button") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                // 発注画面へ遷移
                System.out.println("onSubmit");
                try {
                    List<Contact> lstData = contactDao.getContacts();
                    for (Contact contact : lstData) {
                        System.out.println(contact.getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HashMap<String, String> parameterMap = new HashMap<String, String>();
            }
        };
        // 既存のonSubmitを呼び出しない
        button.setDefaultFormProcessing(false);
        form.add(button);
        form.add(new Label("message", "This is a test page for wicket!"));

    }
}
