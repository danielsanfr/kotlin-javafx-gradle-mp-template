package br.com.danielsan.app

import javafx.scene.Scene
import javafx.stage.Stage
import kotlinx.coroutines.launch
import br.com.danielsan.data.datasources.GithubUserDataSource
import br.com.danielsan.domain.UserSearchUseCase
import br.com.danielsan.app.javafx.CoroutineScopeApplication
import br.com.danielsan.app.javafx.SafeButton
import br.com.danielsan.presentation.UserSearchPresenter
import br.com.danielsan.presentation.UserSearchView
import br.com.danielsan.presentation.models.User
import com.dlsc.formsfx.model.structure.Field
import com.dlsc.formsfx.model.structure.Form
import com.dlsc.formsfx.model.structure.Group
import com.dlsc.formsfx.model.validators.StringLengthValidator
import com.dlsc.formsfx.view.renderer.FormRenderer
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import org.controlsfx.control.Notifications
import java.time.LocalDate

class MainApplication : CoroutineScopeApplication(), UserSearchView {
    private val presenter = UserSearchPresenter(
        UserSearchUseCase(GithubUserDataSource()),
        this
    )
    private val scene1 by lazy { Scene(createForm()) }
    private val scene2 by lazy {
        Scene(FXMLLoader.load(Main::class.java.classLoader.getResource("main.fxml")))
    }

    override fun init() {
        super.init()
        println("init: ${Thread.currentThread()}")
    }

    override fun start(primaryStage: Stage) {
        println("start: ${Thread.currentThread()}")

        primaryStage.minWidth = 640.0
        primaryStage.minHeight = 480.0
        primaryStage.title = "Kotlin JavaFX Gradle Multi-projects"
        primaryStage.scene = scene1
        primaryStage.show()
    }

    override fun onStop() {
        super.onStop()
        println("Esta fechando!!!")
    }

    override fun showUser(user: User) {
        println(user)
        Notifications.create()
            .title("User info")
            .text("Name: ${user.name}\nBio: ${user.bio.getNotificationTrim()}")
            .owner(scene1.window)
            .showInformation()
    }

    private fun String.getNotificationTrim(): String {
        if (length < 30) return this

        var result = substring(0, 30)
        for (i in 30..length step 30) {
            val end = if (i + 30 > length) {
                length
            } else {
                i + 30
            }
            result += "\n${substring(i, end).trim()}"
        }
        return result
    }

    private fun createForm(): Parent {
        val code = Field.ofStringType("")
            .label("Código")
            .placeholder("Ex: 01")
            .required("Informe uma código váligo")
        val password = Field.ofPasswordType("")
            .label("Senha")
//            .required("Informe a senha de acesso")
            .validate(StringLengthValidator.between(4, 16, "Informe a senha de acesso"))
        val date = Field.ofDate(LocalDate.now())
        val form = Form.of(Group.of(code, password, date, Field.ofBooleanType(false).label("Test")))
            .title("Bem vindo")
        return FormRenderer(form).apply {
            alignment = Pos.TOP_RIGHT
            children.add(0, Label("Bem Vindo").also {
                it.maxWidth = Double.MAX_VALUE
                it.alignment = Pos.CENTER
                it.font = Font.font("", FontWeight.BOLD, 30.0)
            })
            children.add(SafeButton().also {
                it.prefWidth = 100.0
                VBox.setMargin(it, Insets(0.0, 10.0, 0.0, 0.0))
                it.text = "Entrar"
                it.setSafeOnMouseClicked {
                    println("Test")
                    launch { presenter.onUserToSearch("danielsanfr") }
                }
            })
        }
    }
}
