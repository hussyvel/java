package patrimonio.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarSenhaTemporaria(String destinatario, String nomeUsuario,
                                      String login, String senhaTemporaria) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

            helper.setFrom("hussyribeiro@gmail.com", "Sistema Patrimonial");
            helper.setTo(destinatario);
            helper.setSubject("Sistema Patrimonial - Nova senha temporaria");
            helper.setText(montarCorpo(nomeUsuario, login, senhaTemporaria), true);

            mailSender.send(msg);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar e-mail: " + e.getMessage(), e);
        }
    }

    private String montarCorpo(String nome, String login, String senha) {
        return """
            <div style="font-family:Segoe UI,Arial,sans-serif;max-width:500px;margin:0 auto;border:1px solid #e0e0e0;border-radius:10px;overflow:hidden">
              <div style="background:#1e3c64;padding:24px;text-align:center">
                <h2 style="color:#fff;margin:0;font-size:18px">🖥 Sistema Patrimonial</h2>
                <p style="color:#a8c4e0;margin:6px 0 0;font-size:13px">Redefinição de senha</p>
              </div>
              <div style="padding:28px 30px;background:#fff">
                <p style="color:#333;font-size:14px">Olá, <strong>%s</strong>!</p>
                <p style="color:#555;font-size:14px;margin-top:10px">
                  Recebemos uma solicitação de redefinição de senha para sua conta.
                  Sua nova senha temporária é:
                </p>
                <div style="background:#f0f7ff;border:2px dashed #2a5298;border-radius:8px;padding:16px;text-align:center;margin:20px 0">
                  <p style="margin:0;font-size:11px;color:#666;text-transform:uppercase;letter-spacing:1px">Login</p>
                  <p style="margin:4px 0 12px;font-size:18px;font-weight:700;color:#1e3c64">%s</p>
                  <p style="margin:0;font-size:11px;color:#666;text-transform:uppercase;letter-spacing:1px">Senha temporária</p>
                  <p style="margin:4px 0 0;font-size:28px;font-weight:700;color:#e67e22;letter-spacing:4px">%s</p>
                </div>
                <p style="color:#e74c3c;font-size:13px;font-weight:600">
                  ⚠️ Por segurança, altere sua senha assim que fizer login.
                </p>
                <p style="color:#aaa;font-size:12px;margin-top:20px">
                  Se você não solicitou essa redefinição, ignore este e-mail ou contate o administrador do sistema.
                </p>
              </div>
              <div style="background:#f5f7fa;padding:14px;text-align:center">
                <p style="color:#aaa;font-size:11px;margin:0">Sistema Patrimonial — Controle de Equipamentos e Periféricos</p>
              </div>
            </div>
            """.formatted(nome, login, senha);
    }
}
