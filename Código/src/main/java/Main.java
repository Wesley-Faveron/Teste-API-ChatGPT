import java.util.Random;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		final String API_KEY = "Código da KEY";
		OpenAiService service = new OpenAiService(API_KEY);
		String texto = "Me fale um pouco sobre você";
		String resposta = "";
		Random gerador = new Random();
		
		int n = 0;
		int k = 0;
		
		CompletionRequest request = CompletionRequest.builder()
		        .model("text-davinci-003")
		        .prompt(texto)
		        .maxTokens(100)
		        .build();
		do {
			new Thread();
			Thread.sleep(gerador.nextInt(3001));
			try {
				resposta = service.createCompletion(request)
				        .getChoices()
				        .get(0)
				        .getText();
				n ++;				
			}catch (Exception e) {
				System.out.println(e);
				k++;
				System.out.println(k + ": Erro!!");
			}			
		}while (n == 0);		
		
		System.out.println(resposta);
	}
}