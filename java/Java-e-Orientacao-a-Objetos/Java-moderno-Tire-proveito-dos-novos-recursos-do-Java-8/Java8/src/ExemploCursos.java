import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Curso
{
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) 
    {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() 
    {
        return nome;
    }

    public int getAlunos() 
    {
        return alunos;
    }
}

public class ExemploCursos
{
	public static void main(String[] args) 
	{
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));COPIAR 
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream().filter(c -> c.getAlunos() >= 100);
		cursos.stream().map(c -> c.getAlunos()); // ou .map(Curso::getAlunos)
		cursos.stream().forEach(total -> System.out.println(total)); // ou .forEach(System.out::println)

		cursos.forEach(c -> System.out.println(c.getNome()));
		
		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
		System.out.println(sum);
		
		Optional<Curso> optionaCurso = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		//optionaCurso.get(); da muita exeption
			//Curso curso = optionaCurso.orElse(null);
			//System.out.println(curso.getNome()); ainda da exeption
				optionaCurso.ifPresent(c -> System.out.println(c.getNome())); // nao da exeption quando é null
				
		//List<Curso> resultado = cursos.stream()
		cursos = cursos.stream()
			.filter(c ->c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		/*Map<String, Integer> mapa = cursos.stream() 
			.filter(c -> c.getAlunos() > 100) 
			.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()));
		System.out.println(mapa); */
		
			cursos.parallelStream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(
						c -> c.getNome(), 
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos +" alunos"));
		}
}