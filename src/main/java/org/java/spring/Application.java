package org.java.spring;


import org.java.spring.db.pojo.Image;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.service.CategoryServ;
import org.java.spring.db.service.ImageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private ImageServ imageServ;
	
	@Autowired
    private CategoryServ categoryServ;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category("Natura");
		Category cat2 = new Category("Spiaggia");
		Category cat3 = new Category("Tramonto");
		Category cat4 = new Category("Autunno");
		Category cat5 = new Category("Foglie");
		Category cat6 = new Category("Coccole");
		Category cat7 = new Category("Gatti");
		Category cat8 = new Category("Animali");
		Category cat9 = new Category("Architettura");
		Category cat10 = new Category("Città");
		Category cat11 = new Category("Moderno");
		Category cat12 = new Category("Fiori");
		Category cat13 = new Category("Primavera");
		Category cat14 = new Category("Foresta");
		Category cat15 = new Category("Notte");
		Category cat16= new Category("Luci");
		Category cat17= new Category("Montagne");
		
		categoryServ.save(cat1);
		categoryServ.save(cat2);
		categoryServ.save(cat3);
		categoryServ.save(cat4);
		categoryServ.save(cat5);
		categoryServ.save(cat6);
		categoryServ.save(cat7);
		categoryServ.save(cat8);
		categoryServ.save(cat9);
		categoryServ.save(cat10);
		categoryServ.save(cat11);
		categoryServ.save(cat12);
		categoryServ.save(cat13);
		categoryServ.save(cat14);
		categoryServ.save(cat15);
		categoryServ.save(cat16);
		categoryServ.save(cat17);
		
		
		
		
		
				
		
		Image img1 = new Image("Tramonto sulla spiaggia", "Una vista mozzafiato del tramonto sul mare con le onde che lambiscono la spiaggia.",
				true, "https://www.google.it/url?sa=i&url=https%3A%2F%2Fit.freepik.com%2Ffoto-vettori-gratuito%2Fnatura&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABAX",  cat1, cat2, cat3);
		
		Image img2 = new Image("Raccolta autunnale", "Una varietà di foglie secche cadute durante l'autunno, con colori vividi e accattivanti.",
				 true,"https://www.google.it/url?sa=i&url=https%3A%2F%2Filritrattodellasalute.tiscali.it%2Fnotizie%2Farticoli%2Fnatura-benessere-corpo-mente%2F&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABAn", cat1, cat4, cat5);
		
		Image img3 = new Image("Gatto sonnolento", "Un gatto domestico che si gode un pisolino tranquillo accanto alla finestra.", 
				true, "https://www.google.it/url?sa=i&url=http%3A%2F%2Fwww.psicologolucamasini.it%2Fit%2Farticolo%2Feffetto-benefico-della-natura-&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABAv", cat6, cat7, cat8);
		
	
		Image img4 = new Image("Architettura urbana","Un'immagine delle moderne architetture urbane con linee nette e riflessi di vetro.",
				true,  "https://www.google.it/url?sa=i&url=https%3A%2F%2Fwww.costacrociere.it%2Fcosta-club%2Fmagazine%2Fnatura.html&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABA3", cat9, cat10, cat11);
		
		
		Image img5 = new Image("Fiori primaverili", "Un mazzo di fiori colorati che sbocciano durante la primavera, creando uno scenario incantevole.",
				
				false, "https://www.google.it/url?sa=i&url=https%3A%2F%2Fit.vecteezy.com%2Ffoto-gratuito%2Fnatura&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABA_", cat1, cat12, cat13);
		
		
		Image img6 = new Image("Vista aerea della foresta","Una prospettiva dall'alto di una foresta lussureggiante con alberi verdi e un fiume serpeggiante.",
				true, "https://www.google.it/url?sa=i&url=https%3A%2F%2Fgognablog.sherpa-gate.com%2Fi-diritti-della-natura%2F&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABBH", cat1, cat14 );
		
		Image img7 = new Image("Città di notte", "Una fotografia notturna di una città vivace con luci scintillanti e grattacieli illuminati.",
				true,"https://www.google.it/url?sa=i&url=https%3A%2F%2Fwww.ad-italia.it%2Fluoghi%2Fitinerari%2F2020%2F04%2F30%2Fpaesaggi-che-rilassano-e-il-respiro-della-natura%2F&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABBP", cat10, cat15, cat16);
		
		
		Image img8 = new Image("Vista aerea delle montagne", "Una veduta panoramica dall'alto delle imponenti montagne con vette innevate e boschi.",
				false, "https://www.google.it/url?sa=i&url=https%3A%2F%2Fwww.massimomarchioro.it%2Ftag%2Fcolori-natura%2F&psig=AOvVaw1n-lZUEc4bAfLp5bAZrVlb&ust=1702734761033000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLi_ztfLkYMDFQAAAAAdAAAAABBX", cat1, cat17);
		
		
		imageServ.save(img1);
		imageServ.save(img2);
		imageServ.save(img3);
		imageServ.save(img4);
		imageServ.save(img5);
		imageServ.save(img6);
		imageServ.save(img7);
		imageServ.save(img8);
		
	}

}
