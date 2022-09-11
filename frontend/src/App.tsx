import Header from "./assets/img/components/Header"
import SalesCard from "./assets/img/components/SalesCard"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
              
            
          </div>
        </section>
      </main>
    </>
  )
}

export default App

