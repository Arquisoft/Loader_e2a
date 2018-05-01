package es.uniovi.asw;





public class AgentsLoaderTest {

//	private EntityManagerFactory factory;
//	private Loader loader;
//	private AgentService agService;
	/*
	@Before
	public void setUp()
	{
		agService = ServicesFactory.getAgentService();
		factory = Persistence.createEntityManagerFactory("test");
		loader = new Loader("excel", 
				"src/test/resources/test1.xlsx", 
				"src/test/resources/TiposAgentes.csv");
		
	}

    @Test
    public void testLoadFromExcel() throws IOException, BusinessException 
    {
    	
    	// Saca la lista de agentes del fichero Excel
		List<Agent> Agents = loader.readAgents(loader.getFormato(), loader.getFilePathExcel());
		assertEquals(5, Agents.size());
				
		Agent pepa = Agents.get(0);
		assertEquals(pepa.getNombre(), "Pepa");
		assertEquals(pepa.getEmail(), "juan@example.com");
		//assertEquals(juan.getLocalizacion(), "105.70.56");
		assertEquals(pepa.getNombreUsuario(), "59019237X");
		
		Agent pablo = Agents.get(3);
		assertEquals(pablo.getNombre(), "Pablo Díaz");
		assertEquals(pablo.getEmail(), "uo251017@uniovi.es");
		//assertEquals(pablo.getLocalizacion(), null);
		assertEquals(pablo.getNombreUsuario(), "58429367Y");
    }

    @Test
    public void findDB() throws BusinessException {
    	EntityManager mapper = factory.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();  // NO FUNCIONA
    	
    	List<Agent> agents = agService.findAllAgents();
    	System.out.println(agents.size());
    	
    	trx.commit();
		mapper.close();
		factory.close();
    }
    */
    
}
