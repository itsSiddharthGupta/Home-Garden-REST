package com.minorproject.homegarden.plants;

public class Result<M> {
	// hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return success.toString();
        } else if (this instanceof Result.Failure) {
            Result.Failure error = (Result.Failure) this;
            return error.toString();
        }
        return "";
    }
	public final static class Success<M> extends Result{
		private String status;
		private M obj;

		Success(String status, M obj) {
			this.obj = obj;
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public M getObj() {
			return obj;
		}

		@Override
		public String toString() {
			return "Success [status=" + status + ", obj=" + obj + "]";
		}

	}

	static class Failure extends Result{
		String status;
		String reason;

		Failure(String status, String reason) {
			this.reason = reason;
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public String getReason() {
			return reason;
		}

		@Override
		public String toString() {
			return "Failure [status=" + status + ", reason=" + reason + "]";
		}

	}
}
