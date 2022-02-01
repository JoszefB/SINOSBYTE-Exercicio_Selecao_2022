package Model;

public class Aluno {
    private int codAluno;
    private String nomeAluno;
    private double	nota1;
    private double nota2;
    private double media;
    private String aprovado;


    public Aluno() {
    }

    public Aluno(int codAluno, String nomeAluno, double	nota1, double nota2, double media, String aprovado) {
        this.codAluno=codAluno;
        this.nomeAluno=nomeAluno;
        this.nota1=nota1;
        this.nota2=nota2;
        this.media=media;
        this.aprovado=aprovado;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia() {
        media = (getNota1()+getNota2())/2;
        setAprovado();
    }

    public void setMedia(double media) {
        this.media = media;
        setAprovado();
    }

    public String getAprovado() {
        return aprovado;
    }

    public void setAprovado() {
        if(getMedia()>=6) {
            aprovado = "SIM";
        }
        else{
            aprovado = "NÃO";
        }
    }

    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }

}

