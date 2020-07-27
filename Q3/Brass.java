public class Brass extends Instruments{
	private Double pipe_length;
	private Integer number_valves;
	private 
	public Brass(String new_manufacturer, String new_country_of_production, int new_year_of_production, float new_weight, String new_colour, Double new_price, String new_material, String new_shape, Boolean new_isElectric, Boolean new_isTuned, Double new_soundQuality, String new_pitch, Boolean new_isBroken){
		super(new_manufacturer, new_country_of_production, new_year_of_production, new_weight, new_colour, new_price, new_material, new_shape, new_isElectric, new_isTuned, new_soundQuality, new_pitch, new_isBroken);
		pipe_length = new_pipe_length;
		number_valves = new_number_valves;
}


}