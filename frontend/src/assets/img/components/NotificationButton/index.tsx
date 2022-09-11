import axios from "axios";
import notificationIcon from "../../../../assets/img/notification-icon.svg"
import { BASE_URL } from "../../../../utils/request";
import './styles.css'

type Props = {
    saleId : number;
}

function handleClick(saleId : number){
  axios(`${BASE_URL}/sales/notification/${saleId}`)
    .then(response => {
      console.log("SUCESSO");
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
        <img src={notificationIcon} alt="Notificar" />
      </div>
    )
}

export default NotificationButton