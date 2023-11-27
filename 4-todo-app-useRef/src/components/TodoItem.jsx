function TodoItem({ todoAction, toDoDate, onDeleteClick }) {
  return (
    <div className="container">
      <div className="row kg-row">
        <div class="col-6">{todoAction}</div>
        <div className="col-4">{toDoDate}</div>
        <div className="col-2">
          <button
            type="button"
            class="btn btn-danger kg-button"
            onClick={() => onDeleteClick(todoAction)}
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
}

export default TodoItem;
