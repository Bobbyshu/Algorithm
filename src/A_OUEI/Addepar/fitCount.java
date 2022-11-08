package A_OUEI.Addepar;

public class fitCount {
    /*
    function input(){
      let limits = {}

      // Uncomment the below two line if you want to give input on prompt
      // limits.lowerlimit = prompt("Enter lower limit: ")
      // limits.upperlimit = prompt("Enter upper limit: ")

      // hard coding the limits values
      limits.lowerlimit = 120
      limits.upperlimit = 160

      return limits
    }

    async function fetchData(){
      try{
        const {lowerlimit, upperlimit} = input()

        let QueryResponse = await fetch("https://jsonmock.hackerrank.com/api/medical_records")
        let Response = await QueryResponse.json()

        const numOfPages = Response.total_pages
        let patientsCount = 0

        for(let i=0; i<numOfPages; i++){
          QueryResponse = await fetch("https://jsonmock.hackerrank.com/api/medical_records?page=" + (i+1))
          Response = await QueryResponse.json()

          for(let j=0; j<Response.data.length; j++){
            const pressure = Response.data[j].vitals.bloodPressureDiastole
            if (pressure >= lowerlimit && pressure <= upperlimit){
              patientsCount++
            }
          }
        }
        console.log("Lower Limit: " + lowerlimit)
        console.log("Upper Limit: " + upperlimit)
        console.log("Number of patients: " + patientsCount)
      }
      catch(err){
        console.log(err)
      }
    }

    fetchData()
         */
}
